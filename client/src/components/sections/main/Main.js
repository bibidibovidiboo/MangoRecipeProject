import React from 'react'
import Slider from '../../slider/Slider';
import Refrigerator from '../../refrigerator/Refrigerator';
import { DndProvider } from 'react-dnd'
import { HTML5Backend } from 'react-dnd-html5-backend'
function Main() {
    return (
        <div>
            <Slider />
            여기는 Main 메인 페이지 입니다

            {/* 냉장고 드래그엔 드롭 */}
            <DndProvider backend={HTML5Backend}>
                <Refrigerator />
            </DndProvider>

        </div>
    )
}

export default Main
