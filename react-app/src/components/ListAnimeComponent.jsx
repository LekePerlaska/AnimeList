import React, { Component } from 'react';
import AnimeService from '../services/AnimeService';

class ListAnimeComponents extends Component {
    
    constructor(props) {
        super(props)

        this.state = {
            animes: []
        }

    }
    componentDidMount() {
        AnimeService.getAnimes().then(res => {
            this.setState({ animes: res.data})
        })
    }

    render() {
        return (
            <div>
                <h2 className="text-center">Homepage: Anime List</h2>
                <div className="row">
                    <table className="tabel table-striped table-bordered">
                        <thead>
                            <tr>
                                <th>Title</th>
                                <th>Type</th>
                                <th>Source</th>
                                <th>Watched</th>
                            </tr>
                        </thead>
                        <tbody>
                            {
                                this.state.animes.map(
                                    (anime) =>
                                    <tr key={anime.id}>
                                        <td> {anime.title} </td>
                                        <td> {anime.type} </td>
                                        <td> {anime.source} </td>
                                        <td> {anime.watched} </td>
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

export default ListAnimeComponents;