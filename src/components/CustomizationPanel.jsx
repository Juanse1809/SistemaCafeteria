import React from 'react';
import { Plus, Coffee } from 'lucide-react';
import ExtraItem from './ExtraItem';
import { formatCurrency, calculateItemSubtotal } from '../utils/formatters';

const CustomizationPanel = ({
  selectedProduct,
  extras,
  selectedExtras,
  specialInstructions,
  onToggleExtra,
  onSpecialInstructionsChange,
  onAddToCart
}) => {
  if (!selectedProduct) {
    return (
      <div className="bg-white rounded-lg shadow-lg p-6">
        <h2 className="text-2xl font-bold text-gray-800 mb-4">Personaliza tu Orden</h2>
        <div className="text-center py-12 text-gray-500">
          <Coffee className="w-16 h-16 mx-auto mb-4 opacity-50" />
          <p>Selecciona una bebida para comenzar</p>
        </div>
      </div>
    );
  }

  const subtotal = calculateItemSubtotal(selectedProduct, selectedExtras);

  return (
    <div className="bg-white rounded-lg shadow-lg p-6">
      <h2 className="text-2xl font-bold text-gray-800 mb-4">Personaliza tu Orden</h2>
      
      <div className="space-y-6">
        <div className="bg-amber-50 p-4 rounded-lg">
          <div className="font-semibold text-gray-800 text-lg">{selectedProduct.name}</div>
          <div className="text-amber-600 font-bold">{formatCurrency(selectedProduct.price)}</div>
        </div>

        <div>
          <h3 className="font-semibold text-gray-800 mb-3">Extras:</h3>
          <div className="space-y-2">
            {extras.map(extra => (
              <ExtraItem
                key={extra.id}
                extra={extra}
                isSelected={selectedExtras.some(e => e.id === extra.id)}
                onToggle={onToggleExtra}
              />
            ))}
          </div>
        </div>

        <div>
          <h3 className="font-semibold text-gray-800 mb-2">Instrucciones Especiales:</h3>
          <textarea
            value={specialInstructions}
            onChange={(e) => onSpecialInstructionsChange(e.target.value)}
            placeholder="Ej: Sin azúcar, bien caliente..."
            className="w-full p-3 border-2 border-gray-200 rounded-lg focus:border-amber-600 focus:outline-none"
            rows="3"
          />
        </div>

        <div className="border-t-2 pt-4">
          <div className="flex justify-between items-center mb-4">
            <span className="text-lg font-semibold text-gray-800">Subtotal:</span>
            <span className="text-2xl font-bold text-amber-600">
              {formatCurrency(subtotal)}
            </span>
          </div>
          <button
            onClick={onAddToCart}
            className="w-full bg-amber-600 text-white py-3 rounded-lg hover:bg-amber-700 transition font-semibold flex items-center justify-center gap-2"
          >
            <Plus className="w-5 h-5" />
            Agregar al Carrito
          </button>
        </div>
      </div>
    </div>
  );
};

export default CustomizationPanel;