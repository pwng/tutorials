var React = require('react');
var ReactDOM = require('react-dom');
import LineExample from './line';

var EmployeeList = React.createClass({
    render: function () {
        return (
            <ul>
                <li>Christophe Coenraets</li>
                <li>Lisa Jones</li>
            </ul>
        );
    }
});

class HomePage extends React.Component {
  render() {
    return (
    	<div>
    	<h1>Hello dong zhi men</h1>
    	<EmployeeList />
	<LineExample />
    	</div>
    );
  }
}

ReactDOM.render(<HomePage/>,  document.getElementById('app'));
