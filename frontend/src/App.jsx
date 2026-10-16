import { useEffect, useState } from 'react';
import './App.css';

function App() {
  const [products, setProducts] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  useEffect(() => {
    async function fetchProducts() {
      try {
        const response = await fetch('http://localhost:8080/api/products');

        if (!response.ok) {
          throw new Error('Failed to fetch products');
        }

        const data = await response.json();
        setProducts(data);
      } catch (err) {
        setError('Could not load products. Please try again.');
      } finally {
        setLoading(false);
      }
    }

    fetchProducts();
  }, []);

  return (
    <div className="app-container">
      {/* Navigation Header */}
      <nav className="navbar">
        <div className="navbar-container">
          <div className="brand">
            <span className="brand-icon">🌿</span>
            <span className="brand-name">Grovia<span>.</span></span>
          </div>
          <span className="nav-tagline">Fresh groceries, delivered simply.</span>
        </div>
      </nav>

      {/* Hero Banner */}
      <header className="hero">
        <div className="hero-inner">
          <span className="hero-pill">✨ Farm to Table Experience</span>
          <h1 className="hero-title">Grovia</h1>
          <p className="hero-subtitle">Fresh groceries, delivered simply.</p>
          <div className="hero-features">
            <span className="feature-badge">🌱 100% Fresh Guarantee</span>
            <span className="feature-badge">⚡ Same-Day Delivery</span>
            <span className="feature-badge">🏷️ Best Local Prices</span>
          </div>
        </div>
      </header>

      {/* Main Product Section */}
      <main className="main-wrapper">
        <div className="products-section-header">
          <div>
            <h2 className="section-title">Our Products</h2>
            <p className="section-subtitle">Browse through our daily handpicked groceries</p>
          </div>
          {!loading && !error && products.length > 0 && (
            <span className="product-count-chip">
              {products.length} {products.length === 1 ? 'Product' : 'Products'} Available
            </span>
          )}
        </div>

        {/* Loading State */}
        {loading && (
          <div className="state-box">
            <div className="spinner"></div>
            <p className="state-message">Loading products...</p>
          </div>
        )}

        {/* Error State */}
        {error && (
          <div className="state-box error-box">
            <span className="state-icon">⚠️</span>
            <p className="state-message">{error}</p>
          </div>
        )}

        {/* Empty State */}
        {!loading && !error && products.length === 0 && (
          <div className="state-box">
            <span className="state-icon">🧺</span>
            <p className="state-message">No products available.</p>
          </div>
        )}

        {/* Product Grid */}
        {!loading && !error && (
          <ul className="products-grid">
            {products.map((product) => (
              <li key={product.id} className="product-card">
                <div className="product-card-visual">
                  <span className="product-emoji">🍎</span>
                  <span className={`stock-tag ${product.stock > 0 ? 'in-stock' : 'out-of-stock'}`}>
                    {product.stock > 0 ? 'In Stock' : 'Out of Stock'}
                  </span>
                </div>
                <div className="product-card-details">
                  <h3 className="product-name">{product.name}</h3>
                  <div className="product-meta-row">
                    <p className="product-price">Price: ₹{product.price}</p>
                    <p className="product-stock">Stock: {product.stock}</p>
                  </div>
                </div>
              </li>
            ))}
          </ul>
        )}
      </main>

      {/* Footer */}
      <footer className="footer">
        <p>Grovia — Fresh groceries, delivered simply.</p>
      </footer>
    </div>
  );
}

export default App;
