package com.enterprise.user.service;

import com.enterprise.user.entity.User;
import com.enterprise.user.repository.UserRepository;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    private User testUser;

    @Before
    public void setUp() {
        testUser = new User();
        testUser.setId(1L);
        testUser.setName("John Doe");
        testUser.setEmail("john@example.com");
        testUser.setActive(true);
    }

    @After
    public void tearDown() {
        testUser = null;
    }

    @Test
    public void testCreateUser() {
        when(userRepository.existsByEmail(testUser.getEmail())).thenReturn(false);
        when(userRepository.save(any(User.class))).thenReturn(testUser);

        User created = userService.createUser(testUser);

        assertNotNull(created);
        assertEquals("John Doe", created.getName());
        assertEquals("john@example.com", created.getEmail());
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateUserWithDuplicateEmail() {
        when(userRepository.existsByEmail(testUser.getEmail())).thenReturn(true);

        userService.createUser(testUser);
    }

    @Test
    public void testFindById() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));

        Optional<User> found = userService.findById(1L);

        assertTrue(found.isPresent());
        assertEquals("John Doe", found.get().getName());
    }

    @Test
    public void testFindByIdNotFound() {
        when(userRepository.findById(999L)).thenReturn(Optional.empty());

        Optional<User> found = userService.findById(999L);

        assertFalse(found.isPresent());
    }

    @Test
    public void testFindAll() {
        User user2 = new User();
        user2.setId(2L);
        user2.setName("Jane Doe");
        user2.setEmail("jane@example.com");

        when(userRepository.findAll()).thenReturn(Arrays.asList(testUser, user2));

        List<User> users = userService.findAll();

        assertNotNull(users);
        assertEquals(2, users.size());
    }

    @Test
    public void testUpdateUser() {
        User updatedDetails = new User();
        updatedDetails.setName("John Updated");
        updatedDetails.setEmail("john.updated@example.com");
        updatedDetails.setActive(false);

        when(userRepository.findById(1L)).thenReturn(Optional.of(testUser));
        when(userRepository.save(any(User.class))).thenReturn(testUser);

        User updated = userService.updateUser(1L, updatedDetails);

        assertNotNull(updated);
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testUpdateUserNotFound() {
        when(userRepository.findById(999L)).thenReturn(Optional.empty());

        userService.updateUser(999L, testUser);
    }

    @Test
    public void testDeleteUser() {
        when(userRepository.existsById(1L)).thenReturn(true);
        doNothing().when(userRepository).deleteById(1L);

        userService.deleteUser(1L);

        verify(userRepository, times(1)).deleteById(1L);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeleteUserNotFound() {
        when(userRepository.existsById(999L)).thenReturn(false);

        userService.deleteUser(999L);
    }
}