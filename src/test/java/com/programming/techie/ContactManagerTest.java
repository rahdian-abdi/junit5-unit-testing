package com.programming.techie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ContactManagerTest {

    @Test
    @DisplayName("Should Create Contact")
    public void shouldCreateContact(){
        // Given
        ContactManager contact = new ContactManager();
        contact.addContact("Afina", "Firdaushafa", "0123456789");
        // WHen
        int contactSize = contact.getAllContacts().size();
        //Then
        Assertions.assertFalse(contact.getAllContacts().isEmpty());
        Assertions.assertEquals(1, contactSize);
    }

    @Test
    @DisplayName("Should not less than 10 digits")
    public void shouldThrowsExceptionWhenPhoneNumberLessThanTenDigits(){
        // Given
        ContactManager contact = new ContactManager();
        // When
        Exception exception = Assertions.assertThrows(RuntimeException.class, () -> {
            contact.addContact("John", "Doe", "1234");
        });
        String error = exception.getMessage();
        // Then
        String msg = "10 digits";
        assertTrue(error.toLowerCase().contains(msg));
    }
  
}