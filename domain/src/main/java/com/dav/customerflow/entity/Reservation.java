package com.dav.customerflow.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDateTime;

import static com.dav.customerflow.constant.DatabaseConstant.TBL_RESERVATION;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = TBL_RESERVATION)
public class Reservation extends BaseEntity {
    @NotBlank(message = "Customer name is required")
    private String customerName;

    @NotBlank(message = "Phone number is required")
    private String phoneNo;

    @NotBlank(message = "Email is required")
    private String email;

    @NotNull(message = "Reservation date is required")
    private LocalDateTime reservationDate;

    @NotNull(message = "Number of guests is required")
    private Integer guestNo;

    @NotNull(message = "Branch is required")
    private Long branchId;

    private Long userId;

    private String notes;

    @NotBlank(message = "Status is required")
    private String status;
}
