package week10;


    import java.lang.annotation.*;

    // Custom annotation to grant users the ability to send messages
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface CanSendMessage {}

    // Custom annotation to specify the necessary permission level to send messages
    @Retention(RetentionPolicy.RUNTIME)
    @Target({ElementType.TYPE, ElementType.METHOD})
    @interface RequiresPermission {
        int value() default 0;
    }

    // Custom annotation to define permission levels for users and admins
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface UserPermission {
        int value() default 0;
    }

    // User class representing regular users in the messaging system
    @UserPermission(1) // Default permission level for users
    class User {
        String username;

        public User(String username) {
            this.username = username;
        }
    }

    // Admin class representing administrators in the messaging system
    @UserPermission(2) // Default permission level for admins
    class Admin {
        String username;

        public Admin(String username) {
            this.username = username;
        }
    }

    // Messaging system class
    class MessagingSystem {

        // Method demonstrating the usage of custom annotations
        @CanSendMessage
        @RequiresPermission(1) // User with permission level 1 can send messages
        public static void sendMessage(User user) {
            System.out.println("Regular user " + user.username + " is restricted from sending messages.");
        }

        @CanSendMessage
        @RequiresPermission(2) // Admin with permission level 2 can send messages
        public static void sendMessage(Admin admin) {
            System.out.println("Admin " + admin.username + " sent a message.");
        }

        public static void main(String[] args) {
            // Creating instances of users and admins with different permission levels
            User regularUser = new User("John");
            Admin adminUser = new Admin("Admin123");

            // Trying to send messages with different users
            trySendMessage(regularUser);
            trySendMessage(adminUser);
        }

        // Method to demonstrate sending messages with custom annotations
        private static void trySendMessage(Object user) {
            try {
                // Reflectively check for annotations and permission levels
                RequiresPermission requiresPermissionAnnotation = user.getClass().getAnnotation(RequiresPermission.class);
                CanSendMessage canSendMessageAnnotation = MessagingSystem.class.getDeclaredMethod("sendMessage", user.getClass())
                        .getAnnotation(CanSendMessage.class);

                if (requiresPermissionAnnotation != null && canSendMessageAnnotation != null) {
                    int requiredPermission = requiresPermissionAnnotation.value();
                    UserPermission userPermissionAnnotation = user.getClass().getAnnotation(UserPermission.class);
                    int userPermission = (userPermissionAnnotation != null) ? userPermissionAnnotation.value() : 0;

                    if (userPermission >= requiredPermission) {
                        MessagingSystem.class.getDeclaredMethod("sendMessage", user.getClass()).invoke(null, user);
                    } else {
                        System.out.println("User does not have sufficient permission to send messages.");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


