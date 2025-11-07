import React from 'react';
import { formatCurrency } from '../utils/formatters';

const ExtraItem = ({ extra, isSelected, onToggle }) => {
  return (
    <label className="flex items-center justify-between p-3 rounded-lg border-2 cursor-pointer hover:bg-gray-50 transition">
      <div className="flex items-center gap-3">
        <input
          type="checkbox"
          checked={isSelected}
          onChange={() => onToggle(extra)}
          className="w-5 h-5 text-amber-600"
        />
        <span className="text-gray-800">{extra.name}</span>
      </div>
      <span className="text-amber-600 font-semibold">
        {extra.price === 0 ? 'Gratis' : formatCurrency(extra.price)}
      </span>
    </label>
  );
};

export default ExtraItem;