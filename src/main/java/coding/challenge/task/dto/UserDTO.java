package coding.challenge.task.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
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


    @Column(name = "phone_number", nullable = false)
    @NotEmpty
    private String phoneNumber;

    private String sector;



}


