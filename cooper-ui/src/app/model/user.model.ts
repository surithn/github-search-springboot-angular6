import { Repos } from 'src/app/model/repos.model';

export class User {
    public login: string;
    public url: number;
    public repos_url: string;
    public avatar_url: string;
    public repos: Repos[];
}
