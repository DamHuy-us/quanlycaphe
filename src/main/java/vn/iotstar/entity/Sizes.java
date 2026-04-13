package vn.iotstar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "Sizes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Sizes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int sizeID;

    @Column(name = "SizeName", nullable = false, columnDefinition = "nvarchar(max)")
    private String sizeName;

    @Column(name = "ExtraCost", nullable = false, precision = 18, scale = 2)
    private BigDecimal extraCost;

    @OneToMany(mappedBy = "size")
    private List<CartMilkTea> cartMilkTeas;

}
