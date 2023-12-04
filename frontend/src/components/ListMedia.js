import React, {useState, useEffect} from 'react';
import {SERVER_URL} from '../constants';
import {Link} from 'react-router-dom';

function ListMedia(props) {
    const [medias, setMedia] = useState([]);
    const [message, setMessage] = useState('');

    useEffect(() => {
    // called once after intial render
    fetchMedia();
    }, [] )


    const fetchMedia = () => {
        console.log("fetchMedia");
        fetch(`${SERVER_URL}/api/media`)
        .then((response) => response.json() ) 
        .then((data) => { 
        console.log("assignment length "+data.length);
        setMedia(data);
        }) 
        .catch(err => console.error(err)); 
  };

  const headers = ['Media Title', 'Type', 'Genre', 'Rating', 'Review', ' ', ' '];

    return (
      <div>
        <h3>Reviews</h3>
        <div margin="auto" >
          <h4>{message}&nbsp;</h4>
              <table className="Center"> 
                <thead>
                  <tr>
                    {headers.map((title, idx) => (<th key={idx}>{title}</th>))}
                  </tr>
                </thead>
                <tbody>
                  {medias.map((row, idx) => (
                    <tr key={idx}>
                      <td>{row.title}</td>
                      <td>{row.type}</td>
                      <td>{row.genre}</td>
                      <td>{row.rating}</td>
                      <td>{row.review}</td>
                      <td>
                        <Link to={`/gradeAssignment/${medias[idx].id}`} >Grade</Link>
                      </td>
                      <td><Link to={`/editReview/${medias[idx].id}`}>Edit</Link></td>

                    </tr>
                  ))}
                </tbody>
              </table>
              <Link to={`/addReview/`}>Add Review</Link>
          </div>
      </div>
    )
}  

export default ListMedia;
