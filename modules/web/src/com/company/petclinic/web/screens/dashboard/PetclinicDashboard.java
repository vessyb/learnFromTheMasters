package com.company.petclinic.web.screens.dashboard;

import com.company.petclinic.entity.Visit;
import com.haulmont.charts.gui.components.charts.SerialChart;
import com.haulmont.charts.gui.data.ListDataProvider;
import com.haulmont.charts.gui.data.SimpleDataItem;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.screen.*;
import freemarker.template.utility.DateUtil;
import org.apache.commons.lang3.time.DateUtils;
import org.eclipse.persistence.jpa.jpql.parser.DateTime;

import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

@UiController("petclinic_PetclinicDashboard")
@UiDescriptor("petclinic-dashboard.xml")
@LoadDataBeforeShow
public class PetclinicDashboard extends Screen {

    @Inject
    private CollectionContainer<Visit> visitsDc;
    @Inject
    private SerialChart visitsPerDay;
    @Inject
    private SerialChart hoursPerDay;

    private Date day;


    @Subscribe
    private void onAfterShow(AfterShowEvent event) {

        Map<Date, Long> collect = visitsDc.getItems()
                .stream()
                .collect(Collectors.groupingBy(v -> DateUtils.round(v.getDate(), Calendar.DATE), Collectors.counting()));

        List<VisitPerDay> visitsList = collect.entrySet()
                .stream()
                .map(e -> new VisitPerDay(e.getKey(), e.getValue()))
                .sorted(Comparator.comparing(VisitPerDay::getDay))
                .collect(Collectors.toList());

        /*//personal struggle
        visitsDc.getItems()
                .stream()
                .filter(i -> "date".equals(visitsDc.getItem().toString()))
                .map(Visit::getHours)
                .collect(Collectors.);*/


        List<SimpleDataItem> dataItems = visitsList.stream()
                .map(SimpleDataItem::new)
                .collect(Collectors.toList());

        visitsPerDay.setDataProvider(new ListDataProvider(dataItems));
    }

    private class VisitPerDay {
        private Date day;
        private long visits;

        public VisitPerDay() {
        }

        public VisitPerDay(Date day, long visits) {
            this.day = day;
            this.visits = visits;
        }


        public Date getDay() {
            return day;
        }

        public void setDay(Date day) {
            this.day = day;
        }

        public long getVisits() {
            return visits;
        }

        public void setVisits(long visits) {
            this.visits = visits;
        }

        private class HoursPerDay {
            private Date day;
            private long hours;

            public HoursPerDay() {
            }

            public HoursPerDay(Date day, long hours) {
                this.day = day;
                this.hours = hours;
            }

            public Date getDay() {
                return day;
            }

            public void setDay(Date day) {
                this.day = day;
            }

            public long getHours() {
                return hours;
            }

            public void setHours(long hours) {
                this.hours = hours;
            }
        }

    }
}