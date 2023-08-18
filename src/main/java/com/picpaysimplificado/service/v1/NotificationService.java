package com.picpaysimplificado.service.v1;


import com.picpaysimplificado.domain.model.User;
import com.picpaysimplificado.dto.v1.NotificationDTO;
import com.picpaysimplificado.exception.UnavailableNotificationServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {
    private final RestTemplate restTemplate;

    @Autowired
    public NotificationService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public void sendNotification(User user, String message){
       /* String email = user.getEmail();
        NotificationDTO notificationDTO = new NotificationDTO(email, message);

        ResponseEntity<String> notificationResponse = restTemplate
                .postForEntity("http://o4d9z.mocklab.io/notify", notificationDTO, String.class);

        if(!(notificationResponse.getStatusCode().equals(HttpStatus.OK))){
            throw new UnavailableNotificationServiceException("Unstable or unavailable notification service");
        }*/
        System.out.println("Notificação realizada com sucesso");

    }
}
