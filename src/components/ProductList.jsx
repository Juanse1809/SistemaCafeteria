import React from 'react';
import ProductCard from './ProductCard';

const ProductList = ({ products, selectedProduct, onProductSelect }) => {
  return (
    <div className="bg-white rounded-lg shadow-lg p-6">
      <h2 className="text-2xl font-bold text-gray-800 mb-4">Selecciona tu Bebida</h2>
      <div className="grid grid-cols-1 sm:grid-cols-2 gap-3">
        {products.map(product => (
          <ProductCard
            key={product.id}
            product={product}
            isSelected={selectedProduct?.id === product.id}
            onSelect={onProductSelect}
          />
        ))}
      </div>
    </div>
  );
};

export default ProductList;