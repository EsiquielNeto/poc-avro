package br.com.studies.controller.dto;

import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonDTO implements Serializable {

    private String name;
    private String documentNumber;
    private Integer age;
    private LocalDate birthday;
    private String gender;
    private String profession;
    private BigDecimal salary;
    private boolean married;
    private AddressDTO addresses;
    private List<ContactDTO> contacts;

    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class AddressDTO {

        private String country;
        private String state;
        private String neighborhood;
        private String street;
        private String number;
        private String complement;
    }


    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ContactDTO {
        private String email;
        private String phone;
    }


}
