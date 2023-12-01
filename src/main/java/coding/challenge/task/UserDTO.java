package coding.challenge.task;



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
public class UserDTO {
    private Long id;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;


    @Email(message = "Please provide a valid email address")
    @NotEmpty
    private String email;

    @NotEmpty
    private String gender;


    @NotEmpty
    private String dateOfBirth;

    @NotEmpty
    private String countryOfCitizen;

    @NotEmpty
    private String maritalStatus;


    private String occupation;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String residentialAddress;


    @NotEmpty
    private String countryOfInterest;

    @NotEmpty
    private String purposeOfTraveling;

}
