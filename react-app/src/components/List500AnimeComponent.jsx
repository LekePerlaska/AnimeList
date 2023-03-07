import { Checkbox } from '@mui/material';
import React, { Component } from 'react';
import AnimeService from '../services/AnimeService';

class List500AnimeComponents extends Component {

    
    constructor(props) {
        super(props)

        this.state = {
            animes: []
        }

        this.updateAnime = this.updateAnime.bind(this); 

    }

    updateAnime(anime) {
        AnimeService.updateAnime(anime, anime.id).then(res => {
            this.setState({value: res.data.value});
            
            console.log(res);
        });
    }

    componentDidMount() {
        AnimeService.getShortListAnime().then(res => {
            this.setState({ animes: res.data})
        });
    }

    
    

    render() {
        return (
            <div>
                <h2 className="text-center">List: 500 Anime</h2>
                <div className="row">
                    <table className="tabel table-striped table-bordered">
                        <thead>
                            <tr>    
                                <th>No.</th>
                                <th>Title</th>
                                <th>Type</th>
                                <th>Source</th>
                                <th>Watched</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.animes.map(
                                    (anime, index) =>
                                    <tr key={anime.id}>
                                        <td>{index+1}</td>
                                        <td> {anime.title} </td>
                                        <td> {anime.type} </td>
                                        <td> {anime.source} </td>
                                        <td> 
                                            {/* {anime.watched}  */}
                                            <input type="checkbox" id={anime.id} value={anime.watched} name="watched" checked={anime.watched} onChange={() => this.updateAnime(anime)}/>
                                        </td>
                                    </tr>
                                )
                            }
                        </tbody>
                    </table>
                </div>
            </div>
        );
    }
}


export default List500AnimeComponents;