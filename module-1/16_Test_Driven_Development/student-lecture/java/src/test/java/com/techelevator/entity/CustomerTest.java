package com.techelevator.entity;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class CustomerTest {

    private Customer subject;

    @Before
    public void setUp() throws Exception {
        Customer.setNextId(1);
        subject = new Customer();
    }

    @Test
    public void getId() {
        assertEquals(1, subject.getId());
        Customer temp = new Customer();
        assertEquals(2, temp.getId());
    }

    @Test
    public void getAgeBirthdayPast() {
        subject.setBirthDate(LocalDate.of(2002, 3, 21));
        assertEquals(18, subject.getAge());
    }

    @Test
    public void getAgeBirthdayFuture() {
        subject.setBirthDate(LocalDate.of(2002, 9, 21));
        assertEquals(17, subject.getAge());
    }

    @Test
    public void getAgeBirthdayToday() {
        subject.setBirthDate(LocalDate.of(2002, 7, 10));
        assertEquals(18, subject.getAge());
    }
}