import { Link } from "react-router-dom"

const Header = () => {
    return (
        <>
            <h1>Library</h1>
            <hr/>
            <ul>
                <li><Link to="/">Login</Link></li>
                <li><Link to="/user">Users</Link></li>
                <li><Link to="/books">Books</Link></li>
            </ul>
        </>
    );
}
export default Header;