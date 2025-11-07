import React, { useState } from 'react';
import Header from '../components/Header';
import ProductList from '../components/ProductList';
import CustomizationPanel from '../components/CustomizationPanel';
import Cart from '../components/Cart';
import { useCart } from '../hooks/useCart';
import { PRODUCTS, EXTRAS } from '../constants/mockData';

const MenuPage = () => {
  const [selectedProduct, setSelectedProduct] = useState(null);
  const [selectedExtras, setSelectedExtras] = useState([]);
  const [specialInstructions, setSpecialInstructions] = useState('');
  const [showCart, setShowCart] = useState(false);
  
  const { cart, addToCart, removeFromCart } = useCart();

  const handleProductSelect = (product) => {
    setSelectedProduct(product);
    setSelectedExtras([]);
    setSpecialInstructions('');
  };

  const toggleExtra = (extra) => {
    setSelectedExtras(prev => {
      const exists = prev.find(e => e.id === extra.id);
      if (exists) {
        return prev.filter(e => e.id !== extra.id);
      }
      return [...prev, extra];
    });
  };

  const handleAddToCart = () => {
    if (!selectedProduct) return;
    addToCart(selectedProduct, selectedExtras, specialInstructions);
    setSelectedProduct(null);
    setSelectedExtras([]);
    setSpecialInstructions('');
  };

  return (
    <div className="min-h-screen bg-gradient-to-br from-amber-50 to-orange-100 p-4">
      <div className="max-w-6xl mx-auto">
        <Header 
          cartCount={cart.length} 
          onCartClick={() => setShowCart(true)} 
        />

        <div className="grid grid-cols-1 lg:grid-cols-2 gap-6">
          <ProductList
            products={PRODUCTS}
            selectedProduct={selectedProduct}
            onProductSelect={handleProductSelect}
          />

          <CustomizationPanel
            selectedProduct={selectedProduct}
            extras={EXTRAS}
            selectedExtras={selectedExtras}
            specialInstructions={specialInstructions}
            onToggleExtra={toggleExtra}
            onSpecialInstructionsChange={setSpecialInstructions}
            onAddToCart={handleAddToCart}
          />
        </div>

        <Cart
          isOpen={showCart}
          onClose={() => setShowCart(false)}
          cartItems={cart}
          onRemoveItem={removeFromCart}
        />
      </div>
    </div>
  );
};

export default MenuPage;