import {Department} from './department';
import {Skills} from './skills';

export class Employee {
    id!: number;
    name!: String;
    salary!: number;
    permanent!: boolean;
    department!: Department;
    skills!: Skills[];
}
