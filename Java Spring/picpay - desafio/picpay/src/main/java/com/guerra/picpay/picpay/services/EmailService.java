package com.guerra.picpay.picpay.services;

import com.guerra.picpay.picpay.DTO.NotificationDTO;
import com.guerra.picpay.picpay.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(Users users,String message){
        String email = users.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, message);
    }

}
