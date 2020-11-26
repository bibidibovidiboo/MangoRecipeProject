import React from 'react';
import { useDrop } from 'react-dnd';
import { ItemTypes } from './ItemTypes';
import OpenRefrigerImage from './refrigeratorImage/RefrigerOpen';
import CloseRefrigerImage from './refrigeratorImage/RefrigerClose';

const style = {
    height: '100%',
    width: '100%',
    marginRight: '1.5rem',
    marginBottom: '1.5rem',
    color: 'white',
    padding: '1rem',
    textAlign: 'center',
    fontSize: '1rem',
    lineHeight: 'normal',
    float: 'left',
};

export const DropBox = () => {
    const [{ canDrop, isOver }, drop] = useDrop({
        accept: ItemTypes.BOX,
        //냉장고에 넣으면 Box 컴포넌트 객체 전달
        drop: () => ({ name: '냉장고' }),
        collect: (monitor) => ({
            isOver: monitor.isOver(),
            canDrop: monitor.canDrop(),

        }),
    });

    const isActive = canDrop && isOver;

    let backgroundColor = '	#FFFFFF';
    // if (isActive) {
    //     backgroundColor = 'darkgreen';
    // }
    // else if (canDrop) {
    //     backgroundColor = 'darkkhaki';
    // }
    return (
        <div ref={drop} style={{ ...style, backgroundColor }}>
            {isActive ? <OpenRefrigerImage /> : <CloseRefrigerImage />}
        </div>
    );
};
