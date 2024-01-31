import { Table } from 'flowbite-react';
import CardBenefitListItem from './CardBenefitListItem';

export default function CardBenefitList() {
  return (
    <div className="overflow-x-auto w-full border-whiteblue border-4 rounded-xl">
      <Table className='w-full'>
        <Table.Body className='divide-y divide-whiteblue'>
          <CardBenefitListItem />
          <CardBenefitListItem />
          <CardBenefitListItem />
        </Table.Body>
      </Table>
    </div>
  );
}
