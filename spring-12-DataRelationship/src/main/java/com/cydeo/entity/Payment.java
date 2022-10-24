package com.cydeo.entity;

import com.cydeo.enums.Status;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.utility.nullability.MaybeNull;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NoArgsConstructor //ALWAYS
@Data
@Table(name = "payments")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "DATE" )
    private LocalDate createdDate;//payment date
    private BigDecimal amount;
    @Enumerated (EnumType.STRING)
    private Status paymentStatus;
    //@OneToOne(cascade = CascadeType.ALL)
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})//cascading doesn't make sence on Many to one
    //The cascade persist is used to specify that if an entity is persisted then all its associated child entities will also be persisted.
    @JoinColumn(name = "payment_detail_id")
    private PaymentDetail paymentDetail;
    @ManyToOne
    private Merchant merchant;//One merchant to many payments, Many payments to one merchant

    public Payment(LocalDate createdDate, BigDecimal amount, Status paymentStatus) {
        this.createdDate = createdDate;
        this.amount = amount;
        this.paymentStatus = paymentStatus;
    }
}
