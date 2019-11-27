package pl.sii.spring.jmx;

import org.springframework.jmx.export.annotation.ManagedNotification;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.jmx.export.notification.NotificationPublisher;
import org.springframework.jmx.export.notification.NotificationPublisherAware;
import org.springframework.stereotype.Component;

import javax.management.Notification;

@Component
@ManagedResource(objectName = "jmxApplication:name=MessageNotifier")
@ManagedNotification(notificationTypes = "MessageNotifier.sendNotification", name = "Test")
public class MessageNotifierImpl implements MessageNotifier, NotificationPublisherAware {
    private NotificationPublisher notificationPublisher;
    @Override
    public void sendNotification() {
        Notification notification = new Notification("MessageNotifier.sendNotification", this, 0, "example Message");
        notificationPublisher.sendNotification(notification);
    }

    @Override
    public void setNotificationPublisher(NotificationPublisher notificationPublisher) {
        this.notificationPublisher = notificationPublisher;
    }
}
