 
package gov.sec.cas.stereotypes;

/**
 *
 * @author Chadr
 */
public class User {
     private String role;

    private User(UserBuilder userBuilder) {
        this.role = userBuilder.role;
    }

    public String getRole() {
        return role;
    }

    public static class UserBuilder {

        private String role;

        public UserBuilder() {
            //empty constructor
        }

        public UserBuilder withRole(String role) {
            this.role = role;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
    
}
