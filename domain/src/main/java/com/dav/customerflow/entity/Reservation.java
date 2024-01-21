package com.dav.customerflow.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
