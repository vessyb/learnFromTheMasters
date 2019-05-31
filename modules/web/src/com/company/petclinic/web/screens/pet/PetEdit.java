package com.company.petclinic.web.screens.pet;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.FileDescriptorResource;
import com.haulmont.cuba.gui.components.FileUploadField;
import com.haulmont.cuba.gui.components.Image;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;
import com.haulmont.cuba.gui.screen.*;
import com.company.petclinic.entity.Pet;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;

import javax.inject.Inject;

@UiController("petclinic_Pet.edit")
@UiDescriptor("pet-edit.xml")
@EditedEntityContainer("petDc")
@LoadDataBeforeShow
public class PetEdit extends StandardEditor<Pet> {

    @Inject
    private Button clearImageBtn;
    @Inject
    private Button downloadImageBtn;
    @Inject
    private Image petPhoto;
    @Inject
    private FileUploadField uploadField;
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private DataManager dataManager;
    @Inject
    private Notifications notifications;
    @Inject
    private ExportDisplay exportDisplay;

    @Subscribe
    private void onAfterShow(AfterShowEvent event) {
        refreshPhoto();
    }

    @Subscribe("clearImageBtn")
    private void onClearImageBtnClick(Button.ClickEvent event) {
        getEditedEntity().setPhoto(null);
        refreshPhoto();
    }

    @Subscribe("downloadImageBtn")
    private void onDownloadImageBtnClick(Button.ClickEvent event) {
        exportDisplay.show(getEditedEntity().getPhoto(), ExportFormat.OCTET_STREAM);
    }

    private void refreshPhoto() {
        boolean hasPhoto = getEditedEntity().getPhoto() != null;
        if (hasPhoto) {
            petPhoto.setSource(FileDescriptorResource.class).setFileDescriptor(getEditedEntity().getPhoto());
        }
        petPhoto.setVisible(hasPhoto);
        clearImageBtn.setEnabled(hasPhoto);
        downloadImageBtn.setEnabled(hasPhoto);
    }

    @Subscribe("uploadField")
    private void onUploadFieldFileUploadSucceed(FileUploadField.FileUploadSucceedEvent event) {
        try {
            FileDescriptor fileDescriptor = uploadField.getFileDescriptor();
            fileUploadingAPI.putFileIntoStorage(uploadField.getFileId(), fileDescriptor);
            FileDescriptor savedFile = dataManager.commit(fileDescriptor);
            getEditedEntity().setPhoto(savedFile);
        } catch (FileStorageException e) {
            notifications.create(Notifications.NotificationType.ERROR).withCaption(e.getMessage()).show();
        }
        refreshPhoto();
    }
    
    
    
    
}