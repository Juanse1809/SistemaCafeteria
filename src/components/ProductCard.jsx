import React from 'react';
import { formatCurrency } from '../utils/formatters';

const ProductCard = ({ product, isSelected, onSelect }) => {
  return (
    <button
      onClick={() => onSelect(product)}
      className={`p-4 rounded-lg border-2 transition text-left ${
        isSelected
          ? 'border-amber-600 bg-amber-50'
          : 'border-gray-200 hover:border-amber-300'
      }`}
    >
      <div className="font-semibold text-gray-800">{product.name}</div>
      <div className="text-amber-600 font-bold">{formatCurrency(product.price)}</div>
      <div className="text-xs text-gray-500">{product.category}</div>
    </button>
  );
};

export default ProductCard;