package com.fedsav.homeaccountance.model.entity;

import com.fedsav.homeaccountance.model.dto.PurchaseItemDto;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "PURCHASES")
@Builder
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class PurchaseItemEntity {
    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    @EqualsAndHashCode.Include
    private String id;
    @Column(name = "purchase_date")
    private LocalDateTime dateTime;
    @Column(name = "item_name")
    private String name;
    @Column(name = "cost")
    private long cost;

    public static PurchaseItemEntity ofDto(PurchaseItemDto dto) {
        return PurchaseItemEntity.builder()
                .id(dto.getId())
                .name(dto.getName())
                .cost(dto.getCost())
                .dateTime(dto.getDateTime())
                .build();
    }
}
