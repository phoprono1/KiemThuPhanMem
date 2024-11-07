package tests;

import base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.AppointmentSchedulingPage;
import pages.ManageAppointmentsPage;

public class BookAppointmentTest extends BaseTest {
    @Test
    @DisplayName("BA_001 - Verify admin is able to book appointment for patient")
    public void testBookRequestedAppointment(){
        AppointmentSchedulingPage appointmentSchedulingPage = dashboardPage.clickAppointmentScheduling();
        ManageAppointmentsPage manageAppointmentsPage = appointmentSchedulingPage.manageAppointmentsPage();
        manageAppointmentsPage.accessPatientAppointment();
        manageAppointmentsPage.bookRequestedAppointment();
        String alertText = manageAppointmentsPage.getToastField();
        Assertions.assertTrue(alertText.contains("Scheduled an appointment for"), "Testcase failed");
    }

    @Test
    @DisplayName("BA_002 - Verify admin is able to book appointment for patient when there is no appointment requests for patient")
    public void testBookNonRequestedAppointment(){
        AppointmentSchedulingPage appointmentSchedulingPage = dashboardPage.clickAppointmentScheduling();
        ManageAppointmentsPage manageAppointmentsPage = appointmentSchedulingPage.manageAppointmentsPage();
        manageAppointmentsPage.accessPatientAppointment();
        manageAppointmentsPage.bookNonRequestedAppointment("Gynecology",1);
        String alertText = manageAppointmentsPage.getToastField();
        Assertions.assertTrue(alertText.contains("Scheduled an appointment for"), "Testcase failed");
    }

    @Test
    @DisplayName("BA_004 - Verify admin is unable to book appointment for patient when there is no available appointment of that type available")
    public void testBookNoAppointmentType(){
        AppointmentSchedulingPage appointmentSchedulingPage = dashboardPage.clickAppointmentScheduling();
        ManageAppointmentsPage manageAppointmentsPage = appointmentSchedulingPage.manageAppointmentsPage();
        manageAppointmentsPage.accessPatientAppointment();
        manageAppointmentsPage.bookNonRequestedAppointment("Surgery",0);
        String alertText = manageAppointmentsPage.getNoResultField();
        System.out.println(alertText);
        Assertions.assertEquals("No available time slots",alertText, "Testcase failed");
    }

    public void testCancelAppointment(){
        AppointmentSchedulingPage appointmentSchedulingPage = dashboardPage.clickAppointmentScheduling();
        ManageAppointmentsPage manageAppointmentsPage = appointmentSchedulingPage.manageAppointmentsPage();
        manageAppointmentsPage.accessPatientAppointment();
        manageAppointmentsPage.cancelAppointment();
    }
}
