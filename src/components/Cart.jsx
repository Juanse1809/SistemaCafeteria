import React from 'react';
import { X, ShoppingCart } from 'lucide-react';
import CartItem from './CartItem';
import { formatCurrency, calculateCartTotal } from '../utils/formatters';

const Cart = ({ isOpen, onClose, cartItems, onRemoveItem }) => {
  if (!isOpen) return null;

  const total = calculateCartTotal(cartItems);

  return (
    <div className="fixed inset-0 bg-black bg-opacity-50 flex items-center justify-center p-4 z-50">
      <div className="bg-white rounded-lg shadow-xl max-w-2xl w-full max-h-[80vh] overflow-hidden flex flex-col">
        <div className="p-6 border-b flex items-center justify-between">
          <h2 className="text-2xl font-bold text-gray-800">Tu Carrito</h2>
          <button
            onClick={onClose}
            className="text-gray-500 hover:text-gray-800"
          >
            <X className="w-6 h-6" />
          </button>
        </div>

        <div className="flex-1 overflow-y-auto p-6">
          {cartItems.length === 0 ? (
            <div className="text-center py-12 text-gray-500">
              <ShoppingCart className="w-16 h-16 mx-auto mb-4 opacity-50" />
              <p>Tu carrito está vacío</p>
            </div>
          ) : (
            <div className="space-y-4">
              {cartItems.map(item => (
                <CartItem
                  key={item.id}
                  item={item}
                  onRemove={onRemoveItem}
                />
              ))}
            </div>
          )}
        </div>

        {cartItems.length > 0 && (
          <div className="p-6 border-t bg-gray-50">
            <div className="flex justify-between items-center mb-4">
              <span className="text-xl font-bold text-gray-800">Total:</span>
              <span className="text-3xl font-bold text-amber-600">
                {formatCurrency(total)}
              </span>
            </div>
            <button className="w-full bg-green-600 text-white py-3 rounded-lg hover:bg-green-700 transition font-semibold">
              Confirmar Pedido
            </button>
          </div>
        )}
      </div>
    </div>
  );
};

export default Cart;