import React from 'react';
import { Coffee, ShoppingCart } from 'lucide-react';

const Header = ({ cartCount, onCartClick }) => {
  return (
    <div className="bg-white rounded-lg shadow-lg p-6 mb-6">
      <div className="flex items-center justify-between">
        <div className="flex items-center gap-3">
          <Coffee className="w-8 h-8 text-amber-600" />
          <h1 className="text-3xl font-bold text-gray-800">Cafetería Universitaria</h1>
        </div>
        <button
          onClick={onCartClick}
          className="relative bg-amber-600 text-white px-4 py-2 rounded-lg hover:bg-amber-700 transition flex items-center gap-2"
        >
          <ShoppingCart className="w-5 h-5" />
          <span>Carrito ({cartCount})</span>
          {cartCount > 0 && (
            <span className="absolute -top-2 -right-2 bg-red-500 text-white rounded-full w-6 h-6 flex items-center justify-center text-sm">
              {cartCount}
            </span>
          )}
        </button>
      </div>
    </div>
  );
};

export default Header;