package com.examen.app_movement.dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExceptionDTO {
  private String message;
  private String code;
}