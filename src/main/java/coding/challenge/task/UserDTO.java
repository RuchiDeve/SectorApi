package coding.challenge.task;



import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "users")
public class UserDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    @NotEmpty
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @NotEmpty
    private String lastName;

    @Column(nullable = false)
    @Email(message = "Please provide a valid email address")
    @NotEmpty
    private String email;

    @Column(nullable = false)
    @NotEmpty
    private String gender;

    @Column(name = "date_of_birth")
    @NotEmpty
    private String dateOfBirth;

    @Column(name = "country_of_citizen", nullable = false)
    @NotEmpty
    private String countryOfCitizen;
    @Column(name = "marital_status", nullable = false)
    @NotEmpty
    private String maritalStatus;
    @Column(name = "phone_number", nullable = false)
    @NotEmpty
    private String phoneNumber;
    @Column(name = "residential_address", nullable = false)
    @NotEmpty
    private String residentialAddress;
    @Column(name = "country_of_interest")
    @NotEmpty
    private String countryOfInterest;
    @Column(name = "purpose_of_traveling", nullable = false)
    @NotEmpty
    private String purposeOfTraveling;

}


