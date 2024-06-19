package br.com.studies.common.domain;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.FieldType;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "person")
public class PersonModel implements Serializable {

  @MongoId(FieldType.OBJECT_ID)
  private String id;
  private String name;
  private String documentNumber;
  private Integer age;
  private LocalDate birthday;
  private GenderEnum gender;
  private String profession;
  private BigDecimal salary;
  private boolean married;
  private AddressModel address;
  private List<ContactModel> contacts;
  @CreatedDate
  private LocalDateTime createdAt;
  @LastModifiedDate
  private LocalDateTime updatedAt;
}
