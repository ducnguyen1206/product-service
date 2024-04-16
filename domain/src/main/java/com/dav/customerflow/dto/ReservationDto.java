package com.dav.customerflow.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import static com.dav.customerflow.constant.CommonConstant.DEFAULT_DATETIME_FORMAT;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservationDto {
    @NotBlank(message = "Customer name is required")
    @Schema(required = true, example = "David John")
    @Pattern(regexp = "^([^0-9]*)$", message = "Invalid name format")
    private String customerName;

    @NotBlank(message = "Phone number is required")
    @Schema(required = true, example = "+84901172375")
    @Pattern(regexp = "^(?:\\+\\d{1,2}\\s?)?\\(?\\d{3}\\)?[-.\\s]?\\d{3}[-.\\s]?\\d{4}$", message = "Invalid phone number format")
    private String phoneNo;

    @NotBlank(message = "Email is required")
    @Schema(required = true, example = "john@gmail.com")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Invalid email format")
    private String email;

    @NotNull(message = "guestNo date is required")
    @Schema(required = true, example = "1")
    @Min(value = 1, message = "There must be at least 1 guest for the reservation")
    private Integer guestNo;

    @JsonFormat(pattern = DEFAULT_DATETIME_FORMAT)
    @NotNull(message = "Reservation date is required")
    @Schema(required = true, example = "2024-01-21T14:40:00.000")
    private LocalDateTime reservationDate;

    @NotNull(message = "Branch is required")
    @Schema(required = true, example = "501")
    private Long branchId;

    private String notes;
}
