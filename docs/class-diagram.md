# Class Diagram — GameZone Unicesar

Complete class structure showing all classes, attributes, methods, and relationships in the GameZone Unicesar application.

```mermaid
classDiagram
    %% ==================== MODEL LAYER ====================
    namespace model {
        class Person {
            <<abstract>>
            -id: int
            -name: String
            -email: String
            +Person(id: int, name: String, email: String)
            +getId(): int
            +getName(): String
            +getEmail(): String
            +getFullName(): String*
        }

        class Customer {
            -purchaseHistory: List~Sale~
            +Customer(id: int, name: String, email: String)
            +getPurchaseHistory(): List~Sale~
            +addPurchase(sale: Sale): void
            +getFullName(): String
        }

        class Seller {
            -employeeCode: String
            -shift: String
            +Seller(id: int, name: String, email: String, employeeCode: String, shift: String)
            +getEmployeeCode(): String
            +getShift(): String
            +getFullName(): String
        }

        class Product {
            <<abstract>>
            -id: int
            -name: String
            -price: double
            -stock: int
            +Product(id: int, name: String, price: double, stock: int)
            +getId(): int
            +getName(): String
            +getPrice(): double
            +getStock(): int
            +updateStock(quantity: int): void
            +getDescription(): String*
        }

        class VideoGame {
            -platform: String
            -genre: String
            -ageRating: String
            +VideoGame(id: int, name: String, price: double, stock: int, platform: String, genre: String, ageRating: String)
            +getPlatform(): String
            +getGenre(): String
            +getAgeRating(): String
            +getDescription(): String
        }

        class Console {
            -brand: String
            -model: String
            -generation: int
            +Console(id: int, name: String, price: double, stock: int, brand: String, model: String, generation: int)
            +getBrand(): String
            +getModel(): String
            +getGeneration(): int
            +getDescription(): String
        }

        class Sale {
            -id: int
            -customer: Customer
            -seller: Seller
            -items: List~SaleItem~
            -date: LocalDateTime
            -status: String
            +Sale(id: int, customer: Customer, seller: Seller)
            +getId(): int
            +getCustomer(): Customer
            +getSeller(): Seller
            +getItems(): List~SaleItem~
            +getDate(): LocalDateTime
            +getStatus(): String
            +addItem(item: SaleItem): void
            +calculateTotal(): double
            +generateReceipt(): String
        }

        class SaleItem {
            -product: Product
            -quantity: int
            -unitPrice: double
            +SaleItem(product: Product, quantity: int, unitPrice: double)
            +getProduct(): Product
            +getQuantity(): int
            +getUnitPrice(): double
            +getSubtotal(): double
        }
    }

    %% ==================== LOGIC LAYER ====================
    namespace logic {
        class ProductService {
            -persistence: ProductPersistence
            +ProductService(persistence: ProductPersistence)
            +registerProduct(product: Product): void
            +findProductById(id: int): Product
            +findAllProducts(): List~Product~
            +updateProductStock(id: int, quantity: int): void
            +deleteProduct(id: int): void
        }

        class CustomerService {
            -persistence: CustomerPersistence
            +CustomerService(persistence: CustomerPersistence)
            +registerCustomer(customer: Customer): void
            +findCustomerById(id: int): Customer
            +findAllCustomers(): List~Customer~
            +updateCustomer(customer: Customer): void
            +deleteCustomer(id: int): void
        }

        class SellerService {
            -persistence: SellerPersistence
            +SellerService(persistence: SellerPersistence)
            +registerSeller(seller: Seller): void
            +findSellerById(id: int): Seller
            +findAllSellers(): List~Seller~
            +updateSeller(seller: Seller): void
            +deleteSeller(id: int): void
        }

        class SaleService {
            -salePersistence: SalePersistence
            -productService: ProductService
            -customerService: CustomerService
            -sellerService: SellerService
            +SaleService(salePersistence: SalePersistence, productService: ProductService, customerService: CustomerService, sellerService: SellerService)
            +registerSale(sale: Sale): void
            +findSaleById(id: int): Sale
            +findAllSales(): List~Sale~
            +findSalesByCustomer(customerId: int): List~Sale~
            +findSalesBySeller(sellerId: int): List~Sale~
            +findSalesByDateRange(startDate: LocalDateTime, endDate: LocalDateTime): List~Sale~
            +calculateDailySalesTotal(date: LocalDate): double
        }
    }

    %% ==================== DATA LAYER ====================
    namespace data {
        class ProductPersistence {
            -filePath: String
            +ProductPersistence(filePath: String)
            +save(product: Product): void
            +findById(id: int): Product
            +findAll(): List~Product~
            +update(product: Product): void
            +delete(id: int): void
            -loadFromFile(): List~Product~
            -saveToFile(products: List~Product~): void
        }

        class CustomerPersistence {
            -filePath: String
            +CustomerPersistence(filePath: String)
            +save(customer: Customer): void
            +findById(id: int): Customer
            +findAll(): List~Customer~
            +update(customer: Customer): void
            +delete(id: int): void
            -loadFromFile(): List~Customer~
            -saveToFile(customers: List~Customer~): void
        }

        class SellerPersistence {
            -filePath: String
            +SellerPersistence(filePath: String)
            +save(seller: Seller): void
            +findById(id: int): Seller
            +findAll(): List~Seller~
            +update(seller: Seller): void
            +delete(id: int): void
            -loadFromFile(): List~Seller~
            -saveToFile(sellers: List~Seller~): void
        }

        class SalePersistence {
            -filePath: String
            +SalePersistence(filePath: String)
            +save(sale: Sale): void
            +findById(id: int): Sale
            +findAll(): List~Sale~
            +update(sale: Sale): void
            +delete(id: int): void
            -loadFromFile(): List~Sale~
            -saveToFile(sales: List~Sale~): void
        }
    }

    %% ==================== PRESENTATION LAYER ====================
    namespace ui {
        class MainFrame {
            -productPanel: ProductPanel
            -personPanel: PersonPanel
            -salePanel: SalePanel
            +MainFrame()
            +initialize(): void
            +show(): void
            +switchPanel(panelName: String): void
        }

        class ProductPanel {
            -productService: ProductService
            +ProductPanel(productService: ProductService)
            +displayProducts(): void
            +addProduct(): void
            +editProduct(): void
            +deleteProduct(): void
            +searchProduct(): void
        }

        class PersonPanel {
            -customerService: CustomerService
            -sellerService: SellerService
            +PersonPanel(customerService: CustomerService, sellerService: SellerService)
            +displayCustomers(): void
            +addCustomer(): void
            +editCustomer(): void
            +deleteCustomer(): void
            +displaySellers(): void
            +addSeller(): void
        }

        class SalePanel {
            -saleService: SaleService
            +SalePanel(saleService: SaleService)
            +displaySales(): void
            +registerNewSale(): void
            +viewSaleDetails(): void
            +generateReport(): void
        }
    }

    %% ==================== RELATIONSHIPS ====================
    %% Inheritance
    Person <|-- Customer : extends
    Person <|-- Seller : extends
    Product <|-- VideoGame : extends
    Product <|-- Console : extends

    %% Composition
    Sale "1" --> "*" SaleItem : contains
    Sale "1" --> "1" Customer : involves
    Sale "1" --> "1" Seller : involves
    SaleItem "1" --> "1" Product : references
    Customer "1" --> "*" Sale : has_purchase_history

    %% Service Dependencies
    ProductService --> ProductPersistence : uses
    CustomerService --> CustomerPersistence : uses
    SellerService --> SellerPersistence : uses
    SaleService --> SalePersistence : uses
    SaleService --> ProductService : uses
    SaleService --> CustomerService : uses
    SaleService --> SellerService : uses

    %% UI Dependencies
    MainFrame --> ProductPanel : contains
    MainFrame --> PersonPanel : contains
    MainFrame --> SalePanel : contains
    ProductPanel --> ProductService : uses
    PersonPanel --> CustomerService : uses
    PersonPanel --> SellerService : uses
    SalePanel --> SaleService : uses
