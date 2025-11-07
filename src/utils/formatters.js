export const formatCurrency = (amount) => {
  return new Intl.NumberFormat('es-CO', {
    style: 'currency',
    currency: 'COP',
    minimumFractionDigits: 0
  }).format(amount);
};

export const calculateItemSubtotal = (product, extras) => {
  const extrasTotal = extras.reduce((sum, extra) => sum + extra.price, 0);
  return product.price + extrasTotal;
};

export const calculateCartTotal = (cartItems) => {
  return cartItems.reduce((sum, item) => sum + item.subtotal, 0);
};