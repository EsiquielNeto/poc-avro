package br.com.studies.common.domain;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressModel {

  private String country;
  private String state;
  private String neighborhood;
  private String street;
  private String number;
  private String complement;
}
