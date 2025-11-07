import React from 'react';
import { X } from 'lucide-react';
import { formatCurrency } from '../utils/formatters';

const CartItem = ({ item, onRemove }) => {
  return (
    <div className="border-2 rounded-lg p-4">
      <div className="flex justify-between items-start mb-2">
        <div>
          <h3 className="font-semibold text-gray-800">{item.product.name}</h3>
          <p className="text-sm text-gray-600">{formatCurrency(item.product.price)}</p>
        </div>
        <button
          onClick={() => onRemove(item.id)}
          className="text-red-500 hover:text-red-700"
        >
          <X className="w-5 h-5" />
        </button>
      </div>
      
      {item.extras.length > 0 && (
        <div className="text-sm text-gray-600 mb-2">
          <strong>Extras:</strong> {item.extras.map(e => e.name).join(', ')}
        </div>
      )}
      
      {item.specialInstructions && (
        <div className="text-sm text-gray-600 mb-2">
          <strong>Notas:</strong> {item.specialInstructions}
        </div>
      )}
      
      <div className="text-right font-bold text-amber-600">
        {formatCurrency(item.subtotal)}
      </div>
    </div>
  );
};

export default CartItem;