package coding.challenge.task.model;

import jakarta.persistence.*;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
 @Table(name = "sectors")
public class Sector {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String selectedCategory;
    @Column(name = "manufacturing", nullable = false)
    private String manufacturing;
    private String construction_matererials;
    private String electronicsandOptics;
    private String food_and_beverages;
    private String Backery_confectionary_products;
    private String Beverages;
    private String Fish_fish_product;
    private String Meat_and_products;
    private String Others;
    private String Sweets_and_snack_food;
    private String Furniture;
    private String Bathroom_sauna;
    private String Kitchen;
    private String Living_room;
    private String Other_Furniture;
    private String Outdoor;
    private String Project_funiture;
    private String Machinery;
    private String Machinery_components;
    private String Machinery_equipment_tools;
    private String Manufacture_of_machinery;
    private String Maritime;
    private String Aluminium_and_steel_workboats;
    private String Boat_Yacht_building;
    private String Ship_repair_and_conversion;
    private String Metal_structures;
    private String Other;
    private String Repair_and_maintenance_service;
    private String  Metalworking;
    private String  Construction_of_metal_structures;
    private String  House_and_buildings;
    private String  Metal_products;
    private String  Metal_works;
    private String CNC_machining;
    private String  Forging, fasteners;
    private String  Gas_plasma_Laser_cutting;
    private String  MIG, TIG, Aluminum_welding;
    private String  Plastics_and_Rubber;
    private String  Packeging;
    private String  Plastic_goods;
    private String  Plastic_processing_technology;
    private String  Blwoing;
    private String  Moulding;
    private String  Plastics_welding_and_processing;
    private String  Plastic_profiles;
    private String  Printing;
    private String  Advertising;
    private String  Book_periodicals_printing;
    private String  Labelling_and_packing_printing;
    private String  Textile_and_Clothing;
    private String  Clothing;
    private String  Textile;
    private String  Wood;
    private String  Other_wood;
    private String  Wooden_building_materials;
    private String  Wooden_houses;
   // private String  others;
    private String  Creative_industries;
    private String  Energy_technology;
    private String  Environment;
    private String  Services;
    private String  Business_services;
    private String  Engineering;
    private String  Information_technology_and_telecommunications;
    private String  Data_processing, Web_portals, E_marketing;
    private String  Programming, consultancy;
    private String  Software, hardware;
    private String  Telecommunications;
    private String  Tourism;
    private String  Translation_services;
    private String  Transport_and_Logistics;
    private String  Air;
    private String  Rail;
    private String  Road;
    private String  Water;
    }

