import { Company } from './company';
export interface Exchange {
  exchangeId: number;
  address: string;
  brief: string;
  remarks: string;
  company: Company[];
}
