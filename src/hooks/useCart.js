import { useState } from 'react';
import { calculateItemSubtotal } from '../utils/formatters';

export const useCart = () => {
  const [cart, setCart] = useState([]);

  const addToCart = (product, extras, specialInstructions) => {
    const cartItem = {
      id: Date.now(),
      product,
      extras: [...extras],
      specialInstructions,
      subtotal: calculateItemSubtotal(product, extras)
    };
    setCart(prev => [...prev, cartItem]);
  };

  const removeFromCart = (itemId) => {
    setCart(prev => prev.filter(item => item.id !== itemId));
  };

  const clearCart = () => {
    setCart([]);
  };

  return { cart, addToCart, removeFromCart, clearCart };
};