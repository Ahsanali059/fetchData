class Product {
    constructor(pname, price) {
        this.pname = pname;
        this.price = price;
    }

    displayProduct() {
        console.log(`Product Name: ${this.pname}`);
        console.log(`Price: ${"Rs:"+this.price.toFixed(2)}`);
    }

   
    setProductName(newName) {
        this.pname = newName;
    }

   
    setProductPrice(newPrice) {
        this.price = newPrice;
    }

   
    calculateDiscountedPrice(discountPercentage) {
        const discountedPrice = this.price * (1 - discountPercentage / 100);
        return discountedPrice;
    }

  
    addDescription(description) {
        this.description = description;
    }

   
    getDescription() {
        return this.description || "No description available.";
    }
}


const myProduct = new Product("Sample Product", 99.99);
myProduct.displayProduct();

myProduct.setProductName("New Product Name");
myProduct.setProductPrice(79.99);
myProduct.displayProduct();

const discount = 10; 
const discountedPrice = myProduct.calculateDiscountedPrice(discount);
console.log(`Discounted Price: ${"Rs:"+discountedPrice.toFixed(2)}`);


myProduct.addDescription("This is a great product with many features.");
console.log("Product Description: " + myProduct.getDescription());




