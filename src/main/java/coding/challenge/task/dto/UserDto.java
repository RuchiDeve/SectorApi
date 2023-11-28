package coding.challenge.task.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    @NotEmpty
    @Size(min = 5, max = 70)
    private String firstName;

    @NotEmpty
    @Size(min = 5, max = 70)
    private String lastName;

    @NotEmpty
    private String fullName;

    @NotEmpty
    @Email(message = "Please provide a valid email address")
    private String email;

    @NotEmpty
    private String gender;

    @NotEmpty
    private String placeOfBirth;

    @NotEmpty
    private String dateOfBirth;

    @NotEmpty
    private String countryOfCitizen;

    @NotEmpty
    private String maritalStatus;

    @NotEmpty
    private String education;

    private String occupation;

    @NotEmpty
    private String phoneNumber;

    @NotEmpty
    private String residentialAddress;

    @NotEmpty
    private String mailingAddress;

    @NotEmpty
    private String countryOfInterest;

    @NotEmpty
    private String purposeOfTraveling;

    @NotEmpty
    private String imageUrl;

}
