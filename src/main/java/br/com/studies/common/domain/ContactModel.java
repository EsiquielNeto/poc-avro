package br.com.studies.common.domain;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContactModel {

  private String email;
  private String phone;
}
