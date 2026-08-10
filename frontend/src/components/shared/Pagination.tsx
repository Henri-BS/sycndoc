import { Flowbite, TextInput } from "flowbite-react";
import { MdArrowBackIos, MdArrowForwardIos } from "react-icons/md";
import { IoMdSearch } from "react-icons/io";
import { User } from "resources/user";
import { customTheme } from "./Custom";

type Page = {
    content: any[];
    size?: number;
    number: number;
    totalElements: number;
    totalPages?: number;
}

type PageProps = {
    pagination: Page;
    onPageChange: Function;
}

export const Pagination = ({ pagination, onPageChange }: PageProps) => {

    const next = (pageNumber: number) => {
        if (pageNumber !== pagination?.totalPages) {
            onPageChange(pagination?.number + 1)
        }
    }

    return (
        <>
            {pagination?.totalElements > 1 ?
                <div className="flex flex-col md:flex-row">
                    <ul className="flex gap-1 items-center w-full mt-4 -space-x-px h-10 text-base ">

                        <li>
                            <button onClick={() => onPageChange(pagination?.number - 1)}
                                className="cursor-pointer flex items-center justify-center text-xl px-2 h-10 text-gray-500 hover:text-yellow-400 bg-white border-2 border-gray-300 hover:border-yellow-300 rounded-l-lg transition duration-500">
                                <MdArrowBackIos /> 
                            </button>
                        </li>

                        <li>
                            <button onClick={() => next(pagination.number + 1)}
                                className="cursor-pointer flex items-center justify-center text-xl px-2 h-10 text-gray-500 hover:text-yellow-400 bg-white border-2 border-gray-300 hover:border-yellow-300 rounded-r-lg transition duration-500">
                                 <MdArrowForwardIos />
                            </button>
                        </li>
                    </ul>

                    <p className="flex items-center justify-center px-6 h-10 w-40 leading-tight rounded-lg text-gray-500 bg-white border-2 border-gray-300">{pagination?.number + 1} de {pagination?.totalPages} </p>
                </div>
                : " "}
        </>
    );
}

type InputSearchProps = {
    pageTitle?: string;
    pageIcon?: any;
    onChange?: (event: React.ChangeEvent<HTMLInputElement> | React.ChangeEvent<HTMLTextAreaElement>) => void;
    value?: string;
}

export const SearchBar = ({ pageTitle, value, onChange, pageIcon }: InputSearchProps) => {

    return (
        <>
            <div className="grid grid-cols-1 md:grid-cols-2 items-center justify-center md:justify-between mt-6">
                <h1 className="flex flex-row items-center gap-x-4 text-2xl text-gray-700 font-semibold">{pageIcon} {pageTitle}</h1>
                <div className="flex md:justify-end">
                    <Flowbite theme={{theme: customTheme}}>
                    <TextInput  icon={IoMdSearch}
                    className="py-2 max-w-[400px]"
                    type="text"
                    id="query"
                    value={value}
                    onChange={onChange}
                    />
                    
                                        </Flowbite>
                </div>
            </div>
        </>
    );
}