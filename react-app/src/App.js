import './App.css';
import ReactDOM from 'react-dom';  
import { Routes, Route, Link, BrowserRouter as Router } from 'react-router-dom'  
import ListAnimeComponents from './components/ListAnimeComponent';
import List500AnimeComponents from './components/List500AnimeComponent';
import ListWatchedAnimeComponents from './components/ListWatchedAnimeComponent';

const routing = (  
  <Router>  
    <div>  
      <h1>Anime List</h1>  
      <h1>React Router Example</h1>  
      <ul>  
        {/* <li>  
          <Link to="/">List Anime</Link>  
        </li>   */}
        <li>  
          <Link to="/500Anime">500 Anime</Link>  
        </li>  
        <li>  
          <Link to="/Watched">Watched</Link>  
        </li>  
      </ul> 
      <div className="container">
      <Routes>  
        {/* <Route exact path="/" element={<ListAnimeComponents />} />   */}
        <Route path="/500Anime" element={<List500AnimeComponents />} />  
        <Route path="/Watched" element={<ListWatchedAnimeComponents />} />  
      </Routes>
      </div>
    </div>  
  </Router>  
)
function App() {
  return (
    routing
  );
}

export default App;
