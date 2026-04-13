package vn.iotstar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Table(name = "MilkTeaType")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "milkTeas")
@ToString(exclude = "milkTeas")
public class MilkTeaType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int milkTeaTypeID;

    @Column(name = "MilkTeaTypeName", columnDefinition = "nvarchar(255)")
    private String milkTeaTypeName;

    // Mối quan hệ 1:N với MilkTea
    @OneToMany(mappedBy = "milkTeaType")
    private List<MilkTea> milkTeas;

}

