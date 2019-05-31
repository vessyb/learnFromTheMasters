package com.company.petclinic.web;

import com.company.petclinic.entity.Pet;
import com.company.petclinic.entity.PetType;
import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.Form;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.components.ValidationErrors;
import com.haulmont.cuba.gui.components.data.value.ContainerValueSource;
import com.haulmont.cuba.gui.components.data.value.DatasourceValueSource;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.model.impl.InstanceContainerImpl;
import com.haulmont.cuba.gui.screen.*;

import javax.inject.Inject;

@UiController("petclinic_TestScreen")
@UiDescriptor("test-screen.xml")
@LoadDataBeforeShow
public class TestScreen extends Screen {

    @Inject
    private Button addTypeBtn;
    @Inject
    private Notifications notifications;
    @Inject
    private TextField<String> txtBox;
   /* @Inject
    private CollectionLoader<Pet> petDl;*/

    private InstanceContainer<PetType> petTypeInstanceContainer;
    @Inject
    private Metadata metadata;
    @Inject
    private CollectionLoader<PetType> petTypeDl;
    @Inject
    private ScreenValidation screenValidation;
    @Inject
    private Form petTypeForm;

    @Subscribe
    private void onInit(InitEvent event) {
        petTypeInstanceContainer = new InstanceContainerImpl<>(metadata.getClass(PetType.class));
        txtBox.setValueSource(new ContainerValueSource<>(petTypeInstanceContainer, "name"));
    }

    @Subscribe
    private void onBeforeShow(BeforeShowEvent event) {
        prepareNewType();
    }

    @Subscribe("addTypeBtn")
    private void onAddTypeBtnClick(Button.ClickEvent event) {
       /* notifications.create()
                .withCaption("You wrote: " + txtBox.getRawValue())
                .withType(Notifications.NotificationType.WARNING)
                .show();*/

        // petDl.load();
        ValidationErrors validationErrors = screenValidation.validateUiComponents(petTypeForm);
        if (validationErrors.isEmpty()) {
            getScreenData().getDataContext().commit();
            prepareNewType();
            petTypeDl.load();
        } else {
            screenValidation.showValidationErrors(this, validationErrors);
        }
    }

    private void prepareNewType() {
        PetType petType = metadata.create(PetType.class);
        PetType mergeType = getScreenData().getDataContext().merge(petType);
        petTypeInstanceContainer.setItem(mergeType);
    }

}